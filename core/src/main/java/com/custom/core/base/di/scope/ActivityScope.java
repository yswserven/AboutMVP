package com.custom.core.base.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by: Ysw on 2020/2/23.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
