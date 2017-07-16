package sloud.springboot.config;
import sloud.springboot.config.data.TransactionDefinitionBuilder;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * Created by ZHANGWEI5095@QQ.COM on 11:02 2017/6/7.
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.tx.advice", value = "enabled", havingValue = "on", matchIfMissing = false)
public class AspectJTransactionManagerConfiguration {
    private final PlatformTransactionManager transactionManager;

    public AspectJTransactionManagerConfiguration(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Bean
    @ConditionalOnProperty(prefix = "spring.tx.advice", value = "enabled", havingValue = "on", matchIfMissing = false)
    TransactionInterceptor txAdvice() {
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        //默认事务
        TransactionAttribute defaultTransactionAttribute = TransactionDefinitionBuilder.create().build();
        source.addTransactionalMethod("post*", defaultTransactionAttribute);
        source.addTransactionalMethod("put*", defaultTransactionAttribute);
        source.addTransactionalMethod("patch*", defaultTransactionAttribute);
        source.addTransactionalMethod("delete*", defaultTransactionAttribute);
        source.addTransactionalMethod("batch*", defaultTransactionAttribute);
        source.addTransactionalMethod("insert*", defaultTransactionAttribute);
        source.addTransactionalMethod("add*", defaultTransactionAttribute);
        source.addTransactionalMethod("create*", defaultTransactionAttribute);
        source.addTransactionalMethod("update*", defaultTransactionAttribute);
        source.addTransactionalMethod("save*", defaultTransactionAttribute);
        source.addTransactionalMethod("merge*", defaultTransactionAttribute);
        source.addTransactionalMethod("remove*", defaultTransactionAttribute);

        //只读事务
        TransactionAttribute readOnlyTransactionAttribute = TransactionDefinitionBuilder.create().setReadOnly(true).build();
        source.addTransactionalMethod("find*", readOnlyTransactionAttribute);
        source.addTransactionalMethod("query*", readOnlyTransactionAttribute);
        source.addTransactionalMethod("search*", readOnlyTransactionAttribute);
        source.addTransactionalMethod("fetch*", readOnlyTransactionAttribute);
        source.addTransactionalMethod("list*", readOnlyTransactionAttribute);
        source.addTransactionalMethod("get*", readOnlyTransactionAttribute);
        source.addTransactionalMethod("count*", readOnlyTransactionAttribute);

        //嵌套事务
        TransactionAttribute newTransactionAttribute = TransactionDefinitionBuilder.create().setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW).build();
        source.addTransactionalMethod("new*", newTransactionAttribute);

        TransactionAttribute supportTransactionAttribute = TransactionDefinitionBuilder.create().setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS).build();
        source.addTransactionalMethod("*", supportTransactionAttribute);

        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    @ConditionalOnProperty(prefix = "spring.tx.advice", value = "enabled", havingValue = "on", matchIfMissing = false)
    Advisor txAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* sloud.springboot.service..*(..))");
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}