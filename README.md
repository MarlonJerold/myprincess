# Princess Framework 👑🐱

<img width="1693" height="598" alt="image" src="https://github.com/user-attachments/assets/19610168-2cdf-430c-ba13-e6fa22986db1" />


## Motivação

O objetivo do Princess é servir como um laboratório para explorar conceitos utilizados por frameworks modernos, ciclo de vida da aplicação, reflexão, gerenciamento de componentes e servidores HTTP.


## Hello World

```java
public class Application {

    public static void registerRoutes(Router router) throws Exception {

        router.get("/hello", ctx -> {
            ctx.json(200, "Hello World");
        });

        router.get("/hello/:id", ctx -> {
            ctx.json(200, "Hello " + ctx.param("id"));
        });

    }
}
```


### Core

- [x] Servidor HTTP
- [x] Sistema de rotas
- [x] Parâmetros de rota
- [x] Sistema de logs
- [ ] Sistema de configuração
- [ ] Ciclo de vida da aplicação
- [ ] Ambiente de desenvolvimento e produção

### Dependency Injection

- [ ] Injeção de dependências
- [ ] Container IoC
- [ ] Escopos (Singleton, Prototype)
- [ ] Injeção por construtor
- [ ] Injeção por campo
- [ ] Injeção por interface

### Web

- [ ] Middlewares
- [ ] Filtros de requisição
- [ ] Interceptadores
- [ ] Tratamento global de exceções
- [ ] Sistema de validação
- [ ] Upload de arquivos
- [ ] Download de arquivos
- [ ] Cookies
- [ ] Sessões

### REST API

- [ ] Serialização JSON automática
- [ ] Desserialização automática
- [ ] Conversão de objetos para JSON
- [ ] Conversão de JSON para objetos
- [ ] Suporte a DTOs
- [ ] Negociação de conteúdo


### Banco de Dados

- [ ] Gerenciamento de conexões
- [ ] Query Builder
- [ ] ORM básico
- [ ] Migrations
- [ ] Repositórios automáticos
- [ ] Transações

### Segurança

- [ ] Autenticação
- [ ] Autorização
- [ ] JWT
- [ ] Criptografia de senhas
- [ ] Controle de CORS
- [ ] Rate Limiting

### Observabilidade

- [ ] Logs estruturados
- [ ] Níveis de log
- [ ] Métricas
- [ ] Health Checks
- [ ] Monitoramento de rotas
- [ ] Tempo de resposta

### Performance

- [ ] Pool de threads
- [ ] Cache em memória
- [ ] Compressão GZIP
- [ ] Benchmark interno
- [ ] Hot Reload

### Arquitetura

- [ ] Descoberta automática de componentes
- [ ] Scanner de classes
- [ ] Sistema de plugins
- [ ] Módulos independentes
- [ ] Eventos da aplicação
