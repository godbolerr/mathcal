# mathcal
Addition service added to spring boot project.


1. Maintain code in codecommit as well as github. - mathcal created . Need to setup ssh for communicating with local 
2. Create group which can do development work - TBD
3. Also create other roles. - TBD
4. Build the code using codebuild. - Done. 
5. create bucket in s3 and push artifacts to s3 - Done. How to retrieve and use this further ? Is it codedeploy ?
6. Open up firewall port to allow external traffic to access EC2 instance on a given port. - rsgsec configured for traffic to these ports.
7. Create load balancer so that 20002 and 20001 can be handled traffic equally.
8. Need URL for health check [ build one controller in the app itself. It should give some vital parameters in future"



