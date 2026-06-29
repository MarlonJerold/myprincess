# Princess Framework 👑🐱

<img width="1693" height="598" alt="image" src="https://github.com/user-attachments/assets/19610168-2cdf-430c-ba13-e6fa22986db1" />


## Motivação

O objetivo do Princess é servir como um laboratório para explorar conceitos utilizados por frameworks modernos, ciclo de vida da aplicação, reflexão, gerenciamento de componentes e servidores HTTP.


## Hello World

Atualmente, você consegue criar sistemas de rotas da seguinte forma, além de facilidade na inicialização do projeto de sua aplicação web.

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
- [x] Sistema de configuração
- [ ] Ciclo de vida da aplicação
- [ ] Ambiente de desenvolvimento e produção
