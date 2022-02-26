pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                updateGitlabCommitStatus name:'build', state: 'running'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                jacoco(execPattern: 'target/jacoco.exec')
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }

        }
        stage('Deploy') {
            steps{
                script{
                    def remote = [:]
                    remote.name = 'deploy'
                    remote.host = '47.102.138.61'
                    remote.user = 'root'
                    remote.password = 'Newbie666'
                    remote.allowAnyHosts = true
                    sshPut remote: remote, from: './target/courselearning-0.0.1.jar', into: '/root/back-end'
                    sshCommand remote: remote, command: '/root/back-end/restart.sh'
                }
            }
        }
    }
    post{
        success{
            updateGitlabCommitStatus name:'build', state: 'success'
        }
        failure{
            updateGitlabCommitStatus name:'build', state: 'failed'
        }
        aborted{
            updateGitlabCommitStatus name:'build', state: 'canceled'
        }
    }
}