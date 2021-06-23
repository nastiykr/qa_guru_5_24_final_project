package customAnnotations;

import io.qameta.allure.Feature;
import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public  @interface  AllureFeatures {
    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Feature("Issues")
    @ManualMember("user1")
    @AutoMember("nastiykr")
    @Component("API")
    @interface Issues {

    }

    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    @Feature("PullRequests")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @Component("API")
    @interface PullRequests {

    }
}