# Sistema de Gerenciamento de Biblioteca

## Descrição
Este é um sistema de gerenciamento de biblioteca desenvolvido em **Java**, utilizando conceitos de **Programação Orientada a Objetos (POO)**. O sistema permite cadastrar livros e usuários, realizar empréstimos e devoluções, e listar livros disponíveis.

## Funcionalidades
- 📌 **Cadastrar Livros**
- 📌 **Cadastrar Usuários**
- 📌 **Emprestar Livros**
- 📌 **Devolver Livros**
- 📌 **Listar Livros Disponíveis**
- 📌 **Menu Interativo no Console**
- 📌 **Excluir Livro e Usuario**
- 📌 **Tratamento de Erros na Entrada de Dados**

## Tecnologias Utilizadas
- **Java**
- **POO (Programação Orientada a Objetos)**
- **Estruturas de Dados (ArrayList, HashSet)**
- **Scanner para entrada de dados no console**

## Estrutura do Sistema
### 📂 **Classes Principais**
- **`Livro`** → Representa um livro na biblioteca
- **`Usuario`** → Representa um usuário (Aluno, Professor, Funcionário)
- **`Emprestimo`** → Relaciona um livro a um usuário (Composição)
- **`Biblioteca`** → Gerencia livros, usuários e empréstimos
- **`TipoUsuario (Enum)`** → Define os tipos de usuários
- **`Main`** → Classe responsável pelo menu interativo

## Como Executar
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/sistema-biblioteca.git
   ```
2. Compile o projeto:
   ```sh
   javac Main.java
   ```
3. Execute o programa:
   ```sh
   java Main
   ```

## Exemplo de Uso
```
===== Sistema de Gerenciamento de Biblioteca =====
1. Cadastrar Livro
2. Cadastrar Usuário
3. Emprestar Livro
4. Devolver Livro
5. Listar Livros Disponíveis
6. Sair
Escolha uma opção: _
```


