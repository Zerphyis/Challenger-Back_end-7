# Desafio Backend - Edição 7

## Introdução
Este projeto é a solução para o **Desafio Backend - Edição 7**, cujo objetivo é desenvolver uma API para disponibilizar informações sobre destinos de viagem, incluindo fotos e textos chamativos para incentivar os usuários a visitarem esses lugares. Além disso, a API também fornece recursos sobre depoimentos de viajantes e integração com Inteligência Artificial (IA) para enriquecer a experiência do usuário.

## Tecnologias Utilizadas
- **Java 17**
- **JPA / Hibernate**
- **MySQL**
- **OpenAI API** 
- **Maven**

## Funcionalidades
- Exibir uma lista de destinos turísticos.
- Fornecer detalhes sobre cada destino, incluindo imagens e descrição.
- Disponibilizar depoimentos de viajantes.
- Integrar IA para recomendação de destinos.

## Endpoints da API

### Destinos 
- **POST /destinos**  
  Adiciona um novo destino.

  ![Image](https://github.com/user-attachments/assets/d4b03316-98c3-40c7-9166-9c04e8b047ea)


- **GET /destinos**  
  Retorna a lista de destinos cadastrados.
  
    ![Image](https://github.com/user-attachments/assets/890d4a5a-d4f8-408b-a4c7-d8162327a3b8)

- **GET /destinos/id**  
  Retorna a um destino pelo id
  
  ![Image](https://github.com/user-attachments/assets/9cb3a1e9-ad4a-4bc5-930f-9e81917d1929)

  - **GET /destinos/search?nome=**  
 Faz uma busca de destino com o nome 

  ![Image](https://github.com/user-attachments/assets/269beeb2-fda6-4d48-b8ac-c70bb88650a5)

  - **PUT /destinos/id** 
 Atualiza o destino com o id passado

![Image](https://github.com/user-attachments/assets/42a0d9bb-e963-45a4-8bc4-cb2995aff485)

 - **DELETE /destinos/id** 
 deleta o destino com o id passado

![Image](https://github.com/user-attachments/assets/f2e9a7fe-8510-4c2f-9d88-14f21f03e7ec)
 

### Depoimentos
- **POST /depoimentos**  
  Adiciona um novo depoimento.

  ![Image](https://github.com/user-attachments/assets/2937d5b3-6665-4703-a0fd-c1ce98cef577)


- **GET /depoimentos**  
  Retorna a lista de depoimentos cadastrados.
  
![Image](https://github.com/user-attachments/assets/d449d6ee-3e43-499d-942d-0001664b625a)

- **GET /depoimentos/id**  
  Retorna a um depoimentos pelo id
  
 ![Image](https://github.com/user-attachments/assets/90394ba1-508c-4ba0-9bfd-c80e9030bdaf)

  - **GET /destinos/depoimentos-home**  
Seleciona aleatoriamente 3 depoimentos 

![Image](https://github.com/user-attachments/assets/87a0c0cd-e308-4a33-b5a9-c5f7b14cfd9b)

  - **PUT /depoimentos/id** 
 Atualiza o depoimentos com o id passado

![Image](https://github.com/user-attachments/assets/f4b69e3e-6431-44b5-a62f-055ca8d93b9d)

 - **DELETE /depoimentos/id** 
 deleta o depoimentos com o id passado

![Image](https://github.com/user-attachments/assets/a614b22b-fc5d-4e14-ada0-f20272ce7aa4)
 
## Configuração do Ambiente
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Acesse o diretório do projeto:
   ```sh
   cd nome-do-projeto
   ```
3. Configure as variáveis de ambiente no `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.ai.openai.api-key=SUA_CHAVE_OPENAI
   ```
4. Execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```
---
Esse projeto faz parte do **Desafio Backend - Edição 7** e foi criado para demonstrar habilidades em desenvolvimento de APIs e integração com IA.

