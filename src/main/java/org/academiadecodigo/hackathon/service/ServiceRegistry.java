package org.academiadecodigo.hackathon.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

    private static ServiceRegistry registry;
    private Map<String, Service> registryMap = new HashMap<>();

    public ServiceRegistry() {
    }

    public static ServiceRegistry getServiceRegistry() {

        if (registry == null) {
            registry = new ServiceRegistry();
        }
        return registry;
    }

    public Service getService(String name) {
        return registryMap.get(name);
    }

    public void registerService(String name, Service service) {
        registryMap.put(name, service);
    }
}
