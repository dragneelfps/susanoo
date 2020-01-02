dependencies {
    implementation(project(":modules:common"))
    implementation(project(":modules:persistence"))
    implementation(project(":modules:service"))
    implementation("org.koin:koin-core:2.0.1")



    implementation("org.http4k:http4k-core:3.206.0")
    implementation("org.http4k:http4k-server-jetty:3.206.0")
    implementation("org.http4k:http4k-client-okhttp:3.206.0")
    implementation("org.http4k:http4k-format-jackson:3.206.0")
    testImplementation("org.koin:koin-test:2.0.1")
}


