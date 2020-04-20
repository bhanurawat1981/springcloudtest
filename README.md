# springcloudtest
Test applications for spring cloud microservices features


1. Download and import following applications to eclipse  :
vz-account-services
vz-eureka-service
vz-user-service
vz-zuul-service

2. Run these aplications using Run As -> Java Application option on resspective Vz{ServiceName}Application.java file from eclipse, in following order (wait for previous app to start before starting next one) :
vz-eureka-service 
vz-account-services (multiple instances should be started using eclipse->Run Configurations -> Arguments -> VM Arguments setting -> -Dserver.port=8002)
vz-zuul-service
vz-user-service

3. Once everything starts fine, hit below URLs to test basic spring-boot microservices, Zuul, Ribbon, Eureka implementation : 
http://localhost:8765/vz-user-service/v1/users
http://localhost:8765/vz-user-service/v1/user/1

4. Check logs and use request Ids set by Sleuth for distributed tracing of logs for each request among vz-account-services, vz-user-service and vz-zuul-service consoles.