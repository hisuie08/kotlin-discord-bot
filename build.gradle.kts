plugins {
    java
    kotlin("jvm") version "1.4.21"
    application
    id("com.github.johnrengelman.shadow") version "7.0.0" //依存含めたjar作成のためのプラグイン
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("net.dv8tion:JDA:4.3.0_277")//JDA Java/KotlinのDiscordAPIラッパー
    implementation("com.jagrosh:jda-utilities:3.0.5") // JDAでコマンドを使うときのやつ
    testCompile("junit", "junit", "4.12")
}

application{
    mainClass.set("${group}.${rootProject.name}.MainKt")
}