
buildscript {
    repositories {
            mavenCentral()
    }
        
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.40")
    }
}

plugins {
}

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.gradle.kotlin.dsl.*;
allprojects {
	println(this)
	//println(it)
	apply<KotlinPlatformJvmPlugin>()
//	apply<JavaLibraryPlugin>()
	//apply(plugin = "kotlin")
	
	repositories {
		mavenCentral()
	}
	
	dependencies {
	    println(this)
        "implementation"(kotlin("stdlib-jdk8"))
		
		println(kotlin("stdlib-jvm8"))
	}
}

allprojects (object: Action<Project> {
	override fun execute(p: Project) {
		println(this);
		println(p);
	}
})	

subprojects (object: Action<Project> {
	override fun execute(p: Project) {
		println("${this}=${this::class}");
		println("${p}=${p::class}");
	}
})