import java.io.File
import java.io.FileFilter

println("Hello, world!")

println(rootDir)

rootProject.name = "kotlin-playbook-root"
rootProject.projectDir = File(settingsDir, "root")

println(this::class)

println(settings::class) 

println(this.rootProject.name)
println(settings.rootProject.name)
println(this.rootProject::class)
println(settings.rootProject::class)


println(rootDir)
include(":hello-world")
include(":types")

for (project in rootProject.children) {
	val projectName = project.name;
	val dir = File(settingsDir, projectName);
	if (!dir.isDirectory()) {
		throw IllegalStateException("project directory is not a directory: " + dir.getAbsolutePath());
	}
	val buildFiles = dir.listFiles { it :File ->
		it.name.startsWith(projectName + ".") && it.name.endsWith(".gradle.kts") && it.isFile()
	}
	if (buildFiles.size == 0) {
	    throw IllegalStateException("Cannot find build file for '${projectName}'");
	}
	if (buildFiles.size > 1) {
	    throw IllegalStateException("Too many pretendents " + java.util.Arrays.asList(buildFiles) + " on build file for project " + projectName);
	}
	
	println(buildFiles::class);
	val buildFile = buildFiles[0];
	project.projectDir = dir;
	project.buildFileName = buildFile.name;
}