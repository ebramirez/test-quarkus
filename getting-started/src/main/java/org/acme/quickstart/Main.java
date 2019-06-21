package org.acme.quickstart;

import io.ap4k.kubernetes.annotation.Container;
import io.ap4k.kubernetes.annotation.Env;
import io.ap4k.openshift.annotation.OpenshiftApplication;

@OpenshiftApplication( sidecars = @Container( image = "bitnami/postgresql:latest", envVars = { @Env( name = "POSTGRESQL_DATABASE", value = "test" ), @Env( name = "POSTGRESQL_USERNAME", value = "test1" ), @Env( name = "POSTGRESQL_PASSWORD", value = "test1" ) } ) )
public class Main {

    public static void main(String[] args) {
      //Your application code goes here.
    }
}