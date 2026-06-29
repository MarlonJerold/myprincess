# Princess Framework 👑🐱

<img width="1693" height="598" alt="image" src="https://github.com/user-attachments/assets/19610168-2cdf-430c-ba13-e6fa22986db1" />


Princess é um mini-framework Java inspirado na simplicidade de frameworks modernos, criado com o objetivo de estudar conceitos internos de desenvolvimento web e construção de frameworks.

Atualmente o projeto está em desenvolvimento e busca oferecer uma experiência simples para criação de aplicações Java com configuração mínima.

## Objetivos

- Inicialização automática da aplicação
- Registro e gerenciamento de endpoints
- Sistema de logs integrado
- Estrutura simples e leve
- Aprendizado dos conceitos internos utilizados por frameworks modernos

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

