package sloud.springboot.config.data;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;

/**
 * Created by ZHANGWEI5095@QQ.COM on 11:02 2017/6/7.
 */
public final class TransactionDefinitionBuilder {
    private TransactionDefinitionBuilder(){
    }
    private int propagationBehavior = TransactionDefinition.PROPAGATION_REQUIRED;

    private int isolationLevel = TransactionDefinition.ISOLATION_DEFAULT;

    private int timeout = TransactionDefinition.TIMEOUT_DEFAULT;

    private boolean readOnly = false;

    public static TransactionDefinitionBuilder create(){
        return new TransactionDefinitionBuilder();
    }

    public TransactionDefinitionBuilder setPropagationBehavior(int propagationBehavior) {
        this.propagationBehavior = propagationBehavior;
        return this;
    }

    public TransactionDefinitionBuilder setIsolationLevel(int isolationLevel) {
        this.isolationLevel = isolationLevel;
        return this;
    }

    public TransactionDefinitionBuilder setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public TransactionDefinitionBuilder setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    public TransactionAttribute build(){
        DefaultTransactionAttribute defaultTransactionAttribute = new DefaultTransactionAttribute();
        if(TransactionDefinition.ISOLATION_DEFAULT != this.isolationLevel)
            defaultTransactionAttribute.setIsolationLevel(this.isolationLevel);
        if(readOnly) defaultTransactionAttribute.setReadOnly(readOnly);
        if(TransactionDefinition.PROPAGATION_REQUIRED != this.propagationBehavior)
            defaultTransactionAttribute.setPropagationBehavior(this.propagationBehavior);

        if(TransactionDefinition.TIMEOUT_DEFAULT != this.timeout)
            defaultTransactionAttribute.setTimeout(this.timeout);

        return defaultTransactionAttribute;
    }
}
