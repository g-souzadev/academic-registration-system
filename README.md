# Sistema de Registro Acadêmico (Cadastro de Alunos e Professores)

Este é um sistema de console desenvolvido em **Java** para o gerenciamento e cadastro de alunos e professores. O projeto foi estruturado aplicando os pilares da **Programação Orientada a Objetos (POO)** e destaca o uso prático de **Polimorfismo** no gerenciamento de dados e na manipulação de listas unificadas.

## Funcionalidades

- **Menu Interativo:** Navegação via console estruturada com a estrutura `do-while` e `switch-case`.
- **Cadastro de Alunos:** Captura de nome, CPF, data de nascimento, matrícula e um array contendo 3 notas.
- **Cadastro de Professores:** Captura de nome, CPF, data de nascimento, disciplina de atuação e titulação acadêmica.
- **Listagem Dinâmica:** Exibição detalhada de todos os perfis cadastrados no sistema através de uma única lista.
- **Busca por Nome:** Mecanismo inteligente de busca que localiza registros comparando apenas o primeiro nome fornecido pelo usuário.
- **Camada de Validação Robustecida:**
    - Validação algorítmica completa de **CPF** (cálculo de dígitos verificadores e barramento de sequências repetidas).
    - Tratamento de exceções e parsing customizado para datas de nascimento (`LocalDate`).
    - Restrição de tamanho numérico e integridade para matrículas acadêmicas.

## Conceitos de POO e Polimorfismo Aplicados

Este projeto serve como um excelente laboratório para conceitos fundamentais de desenvolvimento de software de alta qualidade:

### 1. Herança (`extends`)
A classe abstrata/base `Pessoa` encapsula os atributos universais comum a qualquer indivíduo no ecossistema escolar: `nome`, `cpf` e `dataNascimento`. As classes `Aluno` e `Professor` herdam diretamente de `Pessoa`, estendendo suas características para atender às regras específicas de seus respectivos papéis.

### 2. Polimorfismo de Sobrescrita (`@Override`)
O método `exibirDados()` foi definido na classe base `Pessoa` para imprimir os dados universais. Ambas as classes filhas (`Aluno` e `Professor`) sobrescrevem este método utilizando a instrução `super.exibirDados();`. Isso permite que cada classe filha reaproveite a lógica da classe mãe e adicione seus próprios detalhes específicos em tempo de execução.

### 3. Coleções Genéricas Heterogêneas (`ArrayList<Pessoa>`)
Graças ao polimorfismo, o sistema utiliza uma única lista declarada como `ArrayList<Pessoa>`. Essa lista armazena de forma transparente tanto objetos do tipo `Aluno` quanto do tipo `Professor`. Ao iterar sobre essa lista e disparar o método `pessoa.exibirDados()`, o Java identifica dinamicamente qual subclasse está sendo referenciada e executa o comportamento customizado de forma correta.

## Estrutura do Código

- `Pessoa.java`: Superclasse que define os atributos e comportamentos comuns.
- `Aluno.java`: Subclasse especializada que adiciona atributos de matrícula e notas acadêmicas.
- `Professor.java`: Subclasse especializada que adiciona atributos de disciplina e titulação acadêmica.
- `ValidadorUtil.java`: Classe utilitária focada em segurança, contendo as lógicas de validação de dados e conversão de strings para objetos de tempo (`LocalDate`).
- `Projeto1.java`: Ponto de entrada (`main`) do programa que coordena o fluxo de execução e a interface no console.

## Tecnologias Utilizadas

- **Linguagem:** Java (versão 11 ou superior recomendada)
- **APIs Nativas:** `java.time` para manipulação moderna de datas e `java.util` para gerenciamento de coleções dinâmicas.
- **IDE Utilizada:** IntelliJ IDEA

## Como Executar o Projeto

1. Certifique-se de ter o **JDK (Java Development Kit)** instalado na sua máquina.
2. Clone este repositório para o seu ambiente local:
   ```bash
   git clone https://github.com/g-souzadev/academic-registration-system
   ```
3. Abra a pasta do projeto dentro do seu terminal ou importe-o na sua IDE de preferência.
4. Compile e execute a classe principal `Projeto1.java`.
