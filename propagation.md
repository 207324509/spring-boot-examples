# Spring的7种事务传播行为
1. PROPAGATION_REQUIRED 支持当前事务，如果不存在，则创建一个新事务。 这是默认事务。
2. PROPAGATION_SUPPORTS 支持当前事务，如果不存在，则不执行事务。
3. PROPAGATION_MANDATORY 支持当前事务，如果不存在则抛出异常。 
4. PROPAGATION_REQUIRES_NEW 创建一个新的事务，并挂起当前的事务(如果存在)。
5. PROPAGATION_NOT_SUPPORTED 以非事务方式执行，如果存在，暂停当前事务。
6. PROPAGATION_NEVER 以非事务方式执行，如果事务存在则抛出异常。
7. PROPAGATION_NESTED 如果当前事务存在，则在嵌套事务中执行。
