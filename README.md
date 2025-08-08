<h1 align="center" style="font-weight: bold;">GAMEBUSTERS 💻</h1>

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Mysql](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

<p align="center">
  <b>Sistema para gestão de aluguel de jogos digitais, desenvolvido em Kotlin e com persistência no MySQL.</b>
</p>

---

## ⚙️ Pré-requisitos
- Java 17 ou superior
- Maven 3.8+
- Dependências principais:
  - Kotlin 2.1.20
  - Gson 2.10.1
  - JUnit Jupiter 5.10.0 (testes)

## 🚀 Sobre o Projeto
GameBusters é uma aplicação focada na gestão de aluguel de jogos digitais. Os títulos podem ser obtidos diretamente da API CheapShark, permitindo consulta eficiente do catálogo. O sistema oferece cadastro e gerenciamento de usuários (gamers), além de persistência de dados com Hibernate. 

## ⚡ Como Executar

### Clonando o repositório
```bash
git clone https://github.com/seu-usuario/GameBusters.git
cd GameBusters
```

### Build & Run
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="org.example.gamebusters.main.Main"
```

## 📍 Funcionalidades
- Consulta de jogos via API CheapShark
- Cadastro e gerenciamento de gamers
- (Em desenvolvimento) Locação de jogos

## 📄 Estrutura do Projeto
- `model/` - Modelos de domínio
- `service/` - Serviços e integrações
- `utils/` - Utilitários
- `main/` - Ponto de entrada

---

> Projeto em desenvolvimento para fins acadêmicos e demonstração.
