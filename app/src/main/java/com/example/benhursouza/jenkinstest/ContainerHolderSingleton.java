package com.example.benhursouza.jenkinstest;

import com.google.android.gms.tagmanager.ContainerHolder;

/**
 * Created by benhur.souza on 02/02/2017.
 */
public class ContainerHolderSingleton {
    private static ContainerHolder containerHolder;

    /**
     * Utility class; don't instantiate.
     */
    private ContainerHolderSingleton() {
    }

    public static ContainerHolder getContainerHolder() {
        return containerHolder;
    }

    public static void setContainerHolder(ContainerHolder c) {
        containerHolder = c;
    }
}