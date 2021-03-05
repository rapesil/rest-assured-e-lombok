# Rest Assured + Lombok

Criei esse projeto simples para demonstrar como o Lombok pode facilitar a vida de quem faz testes com o Rest Assured.  
Se quiser saber mais sobre esse código, confira meus posts no medium:      

* [Rest Assured e Lombok para dados de teste, um guia prático](https://medium.com/@rapesil15/rest-assured-e-lombok-para-dados-de-teste-um-guia-pr%C3%A1tico-f94c652be62)  
* [Como criar objetos complexos para seus testes de API criando builders com Lombok](https://medium.com/revista-dtar/como-criar-objetos-complexos-para-seus-testes-de-api-criando-builders-com-lombok-675794d2ded1)
* [Usando objetos Java para facilitar asserções em testes de API com Rest Assured e Lombok](https://medium.com/revista-dtar/usando-objetos-java-para-facilitar-asserções-em-testes-de-api-com-rest-assured-e-lombok-15b20dd2e7bc)

## Pré-requisitos

* Java 8
* Maven
* NodeJs

## Serve Rest 

Para criar esses exemplos utilizei o [ServeRest](https://github.com/PauloGoncalvesBH/ServeRest) que é uma API desenvolvida justamente com finalidade de ajudar testadores a praticar seus conhecimentos em testes de API.


## Como rodar

### Inicializando o ServeRest

* Baixe o projeto
```shell script
https://github.com/PauloGoncalvesBH/ServeRest
```

* Acesse a pasta do projeto
```
cd ServeRest
```

* Inicialize o ServeRest  
```
npx serverest@latest
```

Pronto! O ServeRest está pronto para uso. 

> ServeRest roda em localhost na porta 3000

### Rodando os testes

* Baixe o projeto na sua máquina (abra um novo terminal):

```shell script
git clone https://github.com/rapesil/rest-assured-e-lombok.git
```

* Acesse a pasta do projeto

```shell script
cd rest-assured-e-lombok
```

* Agora é só rodar com:

````
mvn test
````

Dúvidas? rapesil15@gmail.com


