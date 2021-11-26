package com.github.bruno.ecadtestapi.repository.arquivosbancarios;

import com.github.bruno.ecadtestapi.model.ArquivoBancario;
import com.github.bruno.ecadtestapi.repository.filter.ArquivoBancarioFilter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//IMPLEMENTACAO SEMPRE DEVE TER O POSFIXO 'Impl' CASO CONTRARIO O SPRING NAO RECONHECE (CONVECAO SOBRE CONFIGURACAO)
public class ArquivoBancarioRepositoryImpl implements ArquivoBancarioRepositoryQuery{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ArquivoBancario> filtrarArquivos(ArquivoBancarioFilter arquivoBancarioFilter) {

        //CONSTRUTOR DE QUERYS, FUNCIONA SEMELHANDO AO STRINGBUILDER PARA STRINGS
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //QUERY BASEADA NA ENTIDADE X
        CriteriaQuery<ArquivoBancario> criteriaQuery = criteriaBuilder.createQuery(ArquivoBancario.class);

        //ORIGEM CONSULTA
        Root<ArquivoBancario> arquivoBancarioRoot = criteriaQuery.from(ArquivoBancario.class);

        //RESTRICOES / FILTRO
        List<Predicate> listaQueryParametros = new ArrayList<>();

        //APLICANDO FILTROS NA QUERY
        if (!StringUtils.isEmpty(arquivoBancarioFilter.getNomeArquivo())) {

            listaQueryParametros.add(criteriaBuilder
                    .like(criteriaBuilder.upper(arquivoBancarioRoot.get("nomeArquivo")), "%" + arquivoBancarioFilter.getNomeArquivo().toUpperCase() + "%"));
        }

        if (!StringUtils.isEmpty(arquivoBancarioFilter.getTipoArquivo())) {
            listaQueryParametros.add(criteriaBuilder
                    .equal(arquivoBancarioRoot.get("tipoArquivo"), arquivoBancarioFilter.getTipoArquivo()));
        }

        if (Objects.nonNull(arquivoBancarioFilter.getDataInicial())
                && Objects.nonNull(arquivoBancarioFilter.getDataFinal())) {

//            Predicate prdDataEnvioEntreDatasParametro = criteriaBuilder
//                    .between(arquivoBancarioRoot.get("dataEnvio"), arquivoBancarioFilter.getDataInicial(), arquivoBancarioFilter.getDataInicial());
//
//            Predicate prdDataGeracaoEntreDatasParametro = criteriaBuilder.between(
//                    arquivoBancarioRoot.get("dataGeracao"), arquivoBancarioFilter.getDataInicial(), arquivoBancarioFilter.getDataInicial());
//
//            listaQueryParametros.add(criteriaBuilder.or(prdDataEnvioEntreDatasParametro, prdDataGeracaoEntreDatasParametro));

            Predicate prdDataEnvioMaiorIgual = criteriaBuilder.greaterThanOrEqualTo(arquivoBancarioRoot.get("dataEnvio"), arquivoBancarioFilter.getDataInicial());
            Predicate prdDataGeracaoMaiorIgual = criteriaBuilder.greaterThanOrEqualTo(arquivoBancarioRoot.get("dataGeracao"), arquivoBancarioFilter.getDataInicial());

            listaQueryParametros.add( criteriaBuilder.or(prdDataEnvioMaiorIgual,prdDataGeracaoMaiorIgual) );

            Predicate prdDataEnvioMenorIgual = criteriaBuilder.lessThanOrEqualTo(arquivoBancarioRoot.get("dataEnvio"),arquivoBancarioFilter.getDataFinal());
            Predicate prdDataGeracaoMenorIgual =  criteriaBuilder.lessThanOrEqualTo(arquivoBancarioRoot.get("dataGeracao"),arquivoBancarioFilter.getDataFinal());

            listaQueryParametros.add( criteriaBuilder.or(prdDataEnvioMenorIgual,prdDataGeracaoMenorIgual) );


        } else if (Objects.nonNull(arquivoBancarioFilter.getDataInicial())) {

            Predicate prdDataEnvio = criteriaBuilder.greaterThanOrEqualTo(arquivoBancarioRoot.get("dataEnvio"), arquivoBancarioFilter.getDataInicial());
            Predicate prdDataGeracao = criteriaBuilder.greaterThanOrEqualTo(arquivoBancarioRoot.get("dataGeracao"), arquivoBancarioFilter.getDataInicial());

            listaQueryParametros.add(criteriaBuilder.or(prdDataEnvio, prdDataGeracao));
        }else if(Objects.nonNull(arquivoBancarioFilter.getDataFinal())){

            Predicate prdDataEnvioMenorIgual = criteriaBuilder.lessThanOrEqualTo(arquivoBancarioRoot.get("dataEnvio"),arquivoBancarioFilter.getDataFinal());
            Predicate prdDataGeracaoMenorIgual =  criteriaBuilder.lessThanOrEqualTo(arquivoBancarioRoot.get("dataGeracao"),arquivoBancarioFilter.getDataFinal());

            listaQueryParametros.add( criteriaBuilder.or( prdDataEnvioMenorIgual,prdDataGeracaoMenorIgual ) );
        }
        //

        criteriaQuery.where(listaQueryParametros.toArray( new Predicate[listaQueryParametros.size()]) );

        //GERA QUERY SQL A SER EXECUTADA
        TypedQuery<ArquivoBancario> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList(); //resultado execucao
    }

}
