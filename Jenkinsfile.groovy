node("docker") {
    docker.withRegistry('<<https://docker.optum.com/repositories/gchawla6/acis_modernization/>>', '<<docker-credential>>') {
    
        git url: "<<https://github.optum.com/gchawla6/acis_modernization.git>>", credentialsId: '<<git_credential>>'
    
        sh "git rev-parse HEAD > .git/commit-id"
        def commit_id = readFile('.git/commit-id').trim()
        println commit_id
    
        stage "build"
        def app = docker.build "spring-jenkins"
    
        stage "publish"
        app.push 'master'
        app.push "${commit_id}"
    }
}
