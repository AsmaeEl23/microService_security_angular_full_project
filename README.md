<center><h1>Micro-service app with angular and security</h1>
<h2>Architecture of the project</h2>
<img src="images/img.png">
<h2>Services</h2>
</center>
<ul  type="I">
<li><h5>Config service</h5></li>
<h6>Create the service and the config properties</h6>
<h6>Dependency</h6>
<ul>
<li>spring boot actuator</li>
<li>config server</li>
<li>eureka client</li>
<li></li>
</ul>
<img src="images/img_1.png">
<h6>Config test</h6>
<img src="images/img_2.png">


<li><h5>Eureka discovery to register services</h5></li>
<img src="images/img_5.png">
<img src="images/img_3.png">
<p>Or we can use also consul discovery with his dependency</p>
<pre>To run the consul we use those command : 
-> consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.56.1
-> consul agent –dev
 </pre>
<img src="images/img_4.png">
<p>But in this app im using eureka discovery</p>

<li><h5>Gateway-service</h5></li>
<h6>Create the service</h6>
<img src="images/img_6.png">
<h6>Test gateway service</h6>
<img src="images/img_7.png">

<li><h5>Resource-service</h5></li>
<h6>Architecture</h6>
<img src="images/img_8.png">
<h6>Rest controller</h6>
<pre>
@RestController
@RequestMapping("/api")
public class ResourceRestController {
    private ResourceRepository resourceRepository;
    private ResourceServiceImpl resourceService;
    public ResourceRestController(ResourceRepository resourceRepository, ResourceServiceImpl resourceService) {
        this.resourceRepository = resourceRepository;
        this.resourceService = resourceService;
    }
    @GetMapping("/resources")
    public List<.ResourceResponseDto> getAllResources(){
        return resourceService.getAllResources();
    }
    @GetMapping("/resources/{id}")
    public ResourceResponseDto getResourceById(@PathVariable Long id){
        return resourceService.getResourceById(id);
    }
    @PostMapping("/resources")
    public ResourceResponseDto save(@RequestBody ResourceRequestDto resource){
        return resourceService.addResource(resource);
    }
    @PutMapping("/resources/{id}")
    public ResourceResponseDto update(@PathVariable Long id, @RequestBody ResourceRequestDto resource){
        return resourceService.update(id,resource);
    }
    @DeleteMapping("/resources/{id}")
    public void delete(@PathVariable Long id){
        resourceRepository.deleteById(id);
    }
}
</pre>
<h6>Test</h6>
<img src="images/img_9.png">

<li><h5>Reservation service</h5></li>
<p>Create the service</p>
<img src="images/img_15.png">
<h6>Rest controller (i use the service, mappers, dto and openfeign)</h6>
<pre>

</pre>


<li><h3>Test with Swagger</h3></li>
<p>Swagger, which is now known as OpenAPI, is a set of specifications for building APIs. It provides a way to describe 
and document RESTful APIs in a standardized format, allowing developers to understand the API's capabilities withoutaccessing the source code. </p>
<pre>
&lt;dependency&gt;
    &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
    &lt;artifactId&gt;spring-boot-starter-validation&lt;/artifactId&gt;
    &lt;version&gt;3.0.2&lt;/version&gt;
&lt;/dependency&gt;
&lt;dependency&gt;
    &lt;groupId&gt;org.springdoc&lt;/groupId&gt;
    &lt;artifactId&gt;springdoc-openapi-starter-webmvc-ui&lt;/artifactId&gt;
    &lt;version&gt;2.1.0&lt;/version&gt;
&lt;/dependency&gt;
</pre>
<h5>Resources</h5>
<p>Get Resources</p>
<img src="images/img_10.png">
<p>Get Resource by id=2</p>
<img src="images/img_11.png">
<p>Delete Resource which has id=2</p>
<img src="images/img_12.png">
<p>Add Resource</p>
<img src="images/img_13.png">
<p>Get again all resources</p>
<img src="images/img_14.png">

<h5>Reservation-Service</h6>
<img src="images/img_16.png">
<h6>->Personne</h6>
<p>Get Personnes</p>
<img src="images/img_17.png">
<p>Get Personne by id=2</p>
<img src="images/img_18.png">
<p>Delete Personne which has id=2</p>
<img src="images/img_19.png">
<p>Add Personne</p>
<img src="images/img_20.png">
<p>Update Personne id=1</p>
<img src="images/img_21.png">
<p>Get again all Personnes</p>
<img src="images/img_22.png">

<h6>->Reservation</h6>
<p>Get Reservations</p>
<img src="images/img_23.png">
<p>Get Reservation by id=2</p>
<img src="images/img_24.png">
<p>Get Reservation by personne id</p>
<img src="images/img_25.png">
<p>Add Reservation</p>
<img src="images/img_26.png">
<p>Update Reservation id=1</p>
<img src="images/img_27.png">
</ul>



<h2>Angular</h2>
<p>1-Install angular with this command : <color style="color: yellowgreen">npm install @angular/cli</color></p>
<p>2-Create a directory angular-front-app</p>
<p>3-Create angular project with this command : <color style="color: yellowgreen">ng new angular-front-app --directory ./ --no-standalone</color> , (--no-standalone) is for generate the module</p>
<p>Generate component (resources, personnes and reservations components) : <color style="color: yellowgreen">ng g c resources</color></p>
<p>Install bootstrap : <color style="color: yellowgreen">npm i bootstrap bootstrap-icons</color></p>

<h5>Keycloak activation in Angular</h5>
<p>1- Install keycloak-angular and keycloak-js by : <color style="color: yellowgreen">npm install keycloak-angular keycloak-js</color></p>
<p>2- Add factory function in the module which will set up the Keycloak service, so it can be used in the application.</p>
<pre>
function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'app-realm',
        clientId: 'angular-front-app'
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}
</pre>
<h3>Resources</h3>
<img src="images/img_28.png">
<h6>After deleting Resource 1</h6>
<img src="images/img_29.png">

<h3>Personnes</h3>
<img src="images/img_30.png">
<h6>After deleting Personne 1</h6>
<img src="images/img_31.png">
<h6>Get reservations of the Personne 5</h6>
<img src="images/img_32.png">

<h3>Reservations</h3>
<img src="images/img_33.png">
<h6>Personne of reservation</h6>
<img src="images/img_34.png">
<h6>Resource of reservation</h6>
<img src="images/img_35.png">
<h6>Edit reservation</h6>
<img src="images/img_37.png">
<img src="images/img_36.png">
<h6>Delete reservation</h6>
<img src="images/img_38.png">


<h2>Docker</h2>
<h5>DockerCompose file</h5>
<pre>

</pre>
