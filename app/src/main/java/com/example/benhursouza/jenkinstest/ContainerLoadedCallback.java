package com.example.benhursouza.jenkinstest;

import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;

/**
 * Created by benhur.souza on 02/02/2017.
 */
public class ContainerLoadedCallback implements ContainerHolder.ContainerAvailableListener {

    public static void registerCallbacksForContainer(Container container) {
    }

    @Override
    public void onContainerAvailable(ContainerHolder containerHolder, String containerVersion) {
        // We load each container when it becomes available.
        Container container = containerHolder.getContainer();
        registerCallbacksForContainer(container);
    }

}
