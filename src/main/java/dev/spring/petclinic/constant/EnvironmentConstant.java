package dev.spring.petclinic.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum EnvironmentConstant {
    DEV(Constants.DEV_ENV),
    LOCAL(Constants.LOCAL_ENV);

    private final String value;

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Constants {
        public static final String DEV_ENV = "dev";
        public static final String LOCAL_ENV = "local";
    }
}

