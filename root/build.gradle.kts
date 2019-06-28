buildscript {
    repositories {
            mavenCentral()
    }
        
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.40")
    }
}

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
allprojects {
	println(this)
	//println(it)
	apply<KotlinPlatformJvmPlugin>()
	//apply(plugin = "kotlin")
	
	repositories {
		mavenCentral()
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