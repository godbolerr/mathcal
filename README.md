# mathcal
Addition service added to spring boot project.


1. Maintain code in codecommit as well as github. - mathcal created . Need to setup ssh for communicating with local 
2. Create group which can do development work - TBD
3. Also create other roles. - TBD
4. Build the code using codebuild. - Done. 
5. create bucket in s3 and push artifacts to s3 - Done. How to retrieve and use this further ? Is it codedeploy ?
6. Open up firewall port to allow external traffic to access EC2 instance on a given port. - rsgsec configured for traffic to these ports.
7. Create load balancer so that 20002 and 20001 can be handled traffic equally. - LOAD BALANCER CONFIGURED. Unable to connect thru load balancer.
8. Need URL for health check [ build one controller in the app itself. It should give some vital parameters in future"
9. Use API Gateway to create API for the service.

API Key for the MathCal gateway : 6j9LwylZTFabLY7fRU0JW4cP0y8KKhc65IjKCgmf

https://ws647ve6i3.execute-api.us-west-2.amazonaws.com/UAT/addfunction?left=399&right=45 => Used to invoke the API thru the gateway

10. certificate manager.



[ec2-user@ip-172-31-22-89 ~]$ 

aws rds create-db-instance --db-instance-identifier springdemodb --db-instance-class db.t2.micro --engine MySQL --master-username sqladmin --master-user-password password --allocated-storage 5 --storage-encrypted --kms-key-id arn:aws:kms:us-east-1:582246077021:key/90bbd047-b846-4a52-85bf-2645c8d6105c


{
    "DBInstance": {
        "PubliclyAccessible": true,
        "MasterUsername": "sqladmin",
        "MonitoringInterval": 0,
        "LicenseModel": "general-public-license",
        "VpcSecurityGroups": [
            {
                "Status": "active",
                "VpcSecurityGroupId": "sg-2f52bd49"
            }
        ],
        "CopyTagsToSnapshot": false,
        "OptionGroupMemberships": [
            {
                "Status": "in-sync",
                "OptionGroupName": "default:mysql-5-6"
            }
        ],
        "PendingModifiedValues": {
            "MasterUserPassword": "****"
        },
        "Engine": "mysql",
        "MultiAZ": false,
        "DBSecurityGroups": [],
        "DBParameterGroups": [
            {
                "DBParameterGroupName": "default.mysql5.6",
                "ParameterApplyStatus": "in-sync"
            }
        ],
        "AutoMinorVersionUpgrade": true,
        "PreferredBackupWindow": "10:45-11:15",
        "DBSubnetGroup": {
            "Subnets": [
                {
                    "SubnetStatus": "Active",
                    "SubnetIdentifier": "subnet-7b24a11f",
                    "SubnetAvailabilityZone": {
                        "Name": "us-west-2b"
                    }
                },
                {
                    "SubnetStatus": "Active",
                    "SubnetIdentifier": "subnet-c829f6be",
                    "SubnetAvailabilityZone": {
                        "Name": "us-west-2a"
                    }
                },
                {
                    "SubnetStatus": "Active",
                    "SubnetIdentifier": "subnet-d2e30f8a",
                    "SubnetAvailabilityZone": {
                        "Name": "us-west-2c"
                    }
                }
            ],
            "DBSubnetGroupName": "default",
            "VpcId": "vpc-8b48f1ef",
            "DBSubnetGroupDescription": "default",
            "SubnetGroupStatus": "Complete"
        },
        "ReadReplicaDBInstanceIdentifiers": [],
        "AllocatedStorage": 5,
        "BackupRetentionPeriod": 1,
        "PreferredMaintenanceWindow": "tue:08:02-tue:08:32",
        "DBInstanceStatus": "creating",
        "EngineVersion": "5.6.27",
        "DomainMemberships": [],
        "StorageType": "standard",
        "DbiResourceId": "db-QWPF7NAHG6HEGHJGWII2XSJUXY",
        "CACertificateIdentifier": "rds-ca-2015",
        "StorageEncrypted": false,
        "DBInstanceClass": "db.t2.micro",
        "DbInstancePort": 0,
        "DBInstanceIdentifier": "mytestdb"
    }
}


aws rds describe-db-instances 

aws rds create-db-parameter-group --db-parameter-group-name mytestdbparamgroup --db-parameter-group-family MySQL5.6 --description "My new parameter group for test db"


aws rds modify-db-parameter-group --db-parameter-group-name mytestdbparamgroup --parameters "name=max_connections,value=250,method=immediate" --parameters "ParameterName=max_allowed_packet,ParameterValue=1024,ApplyMethod=immediate" --parameters "ParameterName=max_connections,ParameterValue=250,ApplyMethod=immediate"


aws rds create-db-security-group --db-security-group-name mytestdbsecgroup --db-security-group-description "My new security group for test"

aws rds authorize-db-security-group-ingress --db-security-group-name mytestdbsecgroup --cidrip 192.168.1.10/27

aws cloudwatch list-metrics --namespace AWS/RDS


	mon-get-stats FreeStorageSpace --dimensions="DBInstanceIdentifier=mydbinstance" --statistics= Average --namespace="AWS/RDS" --start-time 2009-10-16T00:00:00 --end-time 2009-10-16T00:02:00

aws rds describe-event-subscriptions


arn:aws:sns:us-west-2:582246077021:snsrds


aws rds create-event-subscription --subscription-name myRDSeventsubscription --sns-topic-arn arn:aws:sns:us-west-2:582246077021:snsrds --enabled

aws rds add-source-identifier-to-subscription --subscription-name myRDSeventsubscription --source-identifier mysqldb


        {
            "EventCategories": [
                "failure",
                "failover",



aws rds describe-event-categories

aws rds describe-events --duration 10080

aws rds describe-db-log-files --db-instance-identifier  mytestdb

aws rds download-db-log-file-portion --db-instance-identifier mytestdb --no-paginate --log-file-name mysqlUpgrade > errorlog.txt








=================================
[ec2-user@ip-172-31-22-89 ~]$ aws sns create-topic --name topicOne
{
    "TopicArn": "arn:aws:sns:us-west-2:582246077021:topicOne"
}


[ec2-user@ip-172-31-22-89 ~]$ aws sns create-topic --name topicSms
{
    "TopicArn": "arn:aws:sns:us-west-2:582246077021:topicSms"
}


