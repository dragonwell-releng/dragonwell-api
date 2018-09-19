package com.alibaba.tenant;

import java.util.List;
import java.util.Properties;
import java.util.function.Supplier;

/**
 * TenantContainer is a "virtual container" for a tenant of application, the
 * resource consumption of tenant such as CPU, heap is constrained by the policy
 * of this "virtual container". The thread can run in virtual container by
 * calling <code>TenantContainer.run</code>
 *
 */
public class TenantContainer {

    /**
     * Get total allocated memory of this tenant.
     * @return the total allocated memory of this tenant.
     */
    public synchronized long getAllocatedMemory() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Retrieves the data repository used by this tenant.
     * @return the data repository associated with this tenant.
     */
    public TenantData getTenantData() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Sets the tenant properties to the one specified by argument.
     * @param props the properties to be set, CoW the system properties if it is null.
     */
    public void setProperties(Properties props) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Gets the properties of tenant
     * @return the tenant properties
     */
    public Properties getProperties() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Sets the property indicated by the specified key.
     * @param  key the name of the property.
     * @param  value the value of the property.
     * @return the previous value of the property,
     *         or null if it did not have one.
     */
    public String setProperty(String key, String value) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Gets the property indicated by the specified key.
     * @param  key  the name of the property.
     * @return the  string value of the property,
     *         or null if there is no property with that key.
     */
    public String getProperty(String key) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Removes the property indicated by the specified key.
     * @param  key  the name of the property to be removed.
     * @return the  previous string value of the property,
     *         or null if there was no property with that key.
     */
    public String clearProperty(String key) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * <p>Destroy this tenant container and release occupied resources including memory, cpu, FD, etc.
     *
     * <p>Properties to control the behavioral details of TenantContainer.shutdown:
     * <ul>
     *     <li><b>com.alibaba.tenant.KillThreadInterval</b> Minimum time period between two operations to kill all the
     *          threads belons to this tenant container.
     *     <li><b>com.alibaba.tenant.DebugTenantShutdown</b> Set to "true" to print extra debugging information.
     *     <li><b>com.alibaba.tenant.ShutdownSTWSoftLimit</b> Maximun time period of blocking {@code destroy()} method
     *          from return, if still live threads more aggressive approaches may be employed to kill threads. If not
     *          speicified, will block {@code TenantContainer.destroy()} until all spawned threads got killed.
     * </ul>
     *
     */
    public void destroy() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @return the tenant state
     */
    public TenantState getState() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Set the tenant state
     * @param state used to set
     */
    private void setState(TenantState state) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Returns the tenant' id
     * @return tenant id
     */
    public long getTenantId() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Returns this tenant's name.
     * @return this tenant's name.
     */
    public String getName() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * @return A collection of all threads attached to the container.
     */
    public synchronized Thread[] getAttachedThreads() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * This method is used for creating tenant with configuration files located in com.alibaba.tenant.rcmConf.
     *
     * @param name the name of configuration file.
     * @return tenant created by config file
     * @throws IllegalArgumentException if a live tenant container.
     */
    public static TenantContainer createConfiguredTenantContainer(String name) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Get the tenant created from config file by name.
     *
     * @param name tenant name.
     * @return TenantContainer; null if the name doesn't exist.
     */
    public static TenantContainer getConfiguredTenantContainer(String name) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Get the tenant container by id
     * @param id tenant id.
     * @return the tenant specified by id, null if the id doesn't exist.
     */
    public static TenantContainer getTenantContainerById(long id) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Create tenant container by the configuration
     * @param configuration used to create tenant
     * @return the tenant container
     */
    public static TenantContainer create(TenantConfiguration configuration) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Create tenant container by the configuration
     * @param parent parent tenant container
     * @param configuration used to create tenant
     * @return the tenant container
     */
    public static TenantContainer create(TenantContainer parent, TenantConfiguration configuration) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Create tenant container by the name and configuration
     * @param name the tenant name
     * @param configuration used to create tenant
     * @return the tenant container
     */
    public static TenantContainer create(String name, TenantConfiguration configuration) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Create tenant container by the name and configuration
     * @param parent parent tenant container
     * @param name the tenant name
     * @param configuration used to create tenant
     * @return the tenant container
     */
    public static TenantContainer create(TenantContainer parent, String name, TenantConfiguration configuration) {
        throw new RuntimeException("Dummy AJDK API found");
    }


    /**
     * Gets the tenant id list
     * @return the tenant id list, Collections.emptyList if no tenant exists.
     */
    public static List<Long> getAllTenantIds() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Gets the TenantContainer attached to the current thread.
     * @return The TenantContainer attached to the current thread, null if no
     *         TenantContainer is attached to the current thread.
     */
    public static TenantContainer current() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Gets the cpu time consumed by this tenant
     * @return the cpu time used by this tenant, 0 if tenant cpu throttling or accounting feature is disabled.
     */
    public long getProcessCpuTime() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Gets the heap space occupied by this tenant
     * @return heap space occupied by this tenant, 0 if tenant heap throttling is disabled.
     * @throws IllegalStateException if -XX:+TenantHeapThrottling is not enabled.
     */
    public long getOccupiedMemory() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Runs the code in the target tenant container
     * @param runnable the code to run
     */
    public void run(final Runnable runnable) throws TenantException {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Retrieve the tenant container where <code>obj</code> is allocated in
     * @param obj    object to be searched
     * @return       TenantContainer object whose memory space contains <code>obj</code>,
     *               or null if ROOT tenant container
     */
    public static TenantContainer containerOf(Object obj) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Gets the field value stored in the data repository of this tenant, which is same to call the 
     * {@code TenantData.getFieldValue} on the tenant data object retrieved by {@code TenantContainer.getTenantData}.
     *
     * @param obj           Object the field associates with
     * @param fieldName     Field name
     * @param supplier      Responsible for creating the initial field value
     * @return              Value of field.
     */
    public <K, T> T getFieldValue(K obj, String fieldName, Supplier<T> supplier) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Gets the field value stored in the data repository of this tenant, which is same to call the
     * {@code TenantData.getFieldValue} on the tenant data object retrieved by {@code TenantContainer.getTenantData}.
     *
     * @param obj           Object the field associates with
     * @param fieldName     Field name
     * @return              Value of field, null if not found
     */
    public <K, T> T getFieldValue(K obj, String fieldName) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Runs {@code Supplier.get} in the root tenant.
     * @param supplier target used to call
     * @return the result of {@code Supplier.get}
     */
    public static <T> T primitiveRunInRoot(Supplier<T> supplier) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Runs a block of code in the root tenant. 
     * @param runnable the code to run
     */
    public static void primitiveRunInRoot(Runnable runnable) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Register a new tenant shutdown hook.
     * When the tenant begins its destroy it will
     * start all registered shutdown hooks in some unspecified order and let
     * them run concurrently.
     * @param   hook
     *          An initialized but unstarted <tt>{@link Thread}</tt> object
     */
    public void addShutdownHook(Thread hook) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * De-registers a previously-registered tenant shutdown hook.
     * @param hook the hook to remove
     * @return true if the specified hook had previously been
     * registered and was successfully de-registered, false
     * otherwise.
     */
    public boolean removeShutdownHook(Thread hook) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Link a classloader object to this TenantContainer, the classloader will be marked
     * as 'dead' by calling {@code ClassLoader.dispose()} after this TenantContainer being destroyed
     * @param cl    the ClassLoader object to be associated
     */
    public void addTenantClassLoader(ClassLoader cl) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Try to modify resource limit of current tenant,
     * for resource whose limit cannot be changed after creation of {@code TenantContainer}, its limit will be ignored.
     * @param config  new TenantConfiguration to
     */
    public void update(TenantConfiguration config) {
        throw new RuntimeException("Dummy AJDK API found");
    }


    /**
     * Set the value of {@code Thread.tenantInheritance}
     * @param shouldInherit the new value
     */
    public static void setCurrentThreadInheritance(boolean shouldInherit) {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Hide current thread from TenantThreadStop request.
     * Should be used with {@code unmaskTenantShutdown} in pairs to mark a code snippet
     * to be immune to {@code TenantContainer.destroy}.
     *
     * A common pattern to use these two APIs would be
     * <pre>
     *     tenant.maskTenantShutdown();
     *     try {
     *         // Uninterruptible operation
     *         ... ...
     *     } finally {
     *         tenant.unmaskTenantShutdown();
     *     }
     * </pre>
     */
    public static void maskTenantShutdown() {
        throw new RuntimeException("Dummy AJDK API found");
    }

    /**
     * Restore current thread from {@code maskTenantShutdown}.
     * If {@code TenantContainer.destroy()} happens between
     * {@code maskTenantShutdown} and {@code unmaskTenantShutdown},
     * the "masked" thread will start external exit protocol
     * immediately after returning from {@code unmaskTenantShutdown}.
     */
    public static void unmaskTenantShutdown() {
        throw new RuntimeException("Dummy AJDK API found");
    }
}

