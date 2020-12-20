plugins {
    java
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "6.1.0" //依存含めたjar作成のためのプラグイン
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("net.dv8tion:JDA:4.2.0_211") //JDA Java/KotlinのDiscordAPIラッパー
    implementation("com.jagrosh:jda-utilities:3.0.5") // JDAでコマンドを使うときのやつ
    testCompile("junit", "junit", "4.12")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.shadowJar{
    manifest{
        attributes["Main-Class"] = "com.example.examplebot.MainKt"
    }
}