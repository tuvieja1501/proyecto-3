package biblioteca.salas.duoc.biblioteca.salas.duoc.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API 2026 Reservas de salas")
                        .version("1.0")
                        .description("Documentación de la API para el sistema de reserva de salas"));
    }
}