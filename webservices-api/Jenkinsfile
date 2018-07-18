node {

    withMaven(maven:'maven') {

        stage('Checkout') {
            git url: 'https://github.com/ChaitanyaMM/eye-master.git', credentialsId: 'ChaitanyaMM', branch: 'master'
        }

        stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

        stage('Image') {
            dir ('webservices-api') {
                def app = docker.build "localhost:5000/webservices-api:${env.version}"
                app.push()
            }
        }
        
         stage('QA') {
            dir ('webservices-api') {
                def app = docker.build "localhost:5000/webservices-api:${env.version}"
                app.push()
            }
        }

        stage ('Run') {
            docker.image("localhost:5000/webservices-api:${env.version}").run('-p 3333:3333 -h webapp --name webapp --link eureka --link product')
        }

        stage ('Final') {
            build job: 'gateway-service-pipeline', wait: false
        }      

    }

}