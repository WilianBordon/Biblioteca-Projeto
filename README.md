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
System.out.println(" \n======================================   ");
            System.out.println("SISTEMA DE GERENCIAMENTO DE BIBLIOTECA   ");
            System.out.println("======================================\n ");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2️ - Cadastrar Usuário");
            System.out.println("3️ - Emprestar Livro");
            System.out.println("4️ - Devolver Livro");
            System.out.println("5 - Listar Livros Disponíveis");
            System.out.println("6️ - Listar Usuários Cadastrados");
            System.out.println("7️ - Listar Todos os Livros");
            System.out.println("8 - Excluir Usuário");
            System.out.println("9️ - Excluir Livro");
            System.out.println("0️ - Sair\n");
            System.out.print("Escolha uma opção: ");
```


