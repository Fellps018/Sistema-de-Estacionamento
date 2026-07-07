# 🚗 Sistema de Estacionamento (Lógica Abstrata)

Este projeto é um sistema simples de estacionamento desenvolvido em Java com foco em **lógica de programação e modelagem de estado**, sem persistência de dados ou uso de frameworks avançados.

---

## 🧠 Ideia por trás do projeto

A proposta principal não é simular um estacionamento realista, mas sim criar um **modelo abstrato de controle de vagas**.

O sistema não trabalha com representação física de veículos ou mapeamento de posições. Em vez disso, ele utiliza uma abordagem simplificada de **consumo de recursos**:

- Cada veículo representa um consumo de vagas.
- Carros e motos ocupam 1 unidade.
- Caminhões ocupam 2 unidades.
- O estacionamento é tratado como um conjunto de capacidade limitada (10 unidades).

A estrutura `ArrayList` usada no código não representa veículos reais, mas sim um **controle simbólico de ocupação de vagas**, funcionando como um contador dinâmico de uso do sistema.

Essa abordagem prioriza:
- Raciocínio lógico
- Controle de estado
- Regras de negócio simples
- Abstração de recursos

---

## ⚙️ Funcionalidades

- Entrada de veículos (carro, moto e caminhão)
- Controle de vagas disponíveis
- Registro de horário de entrada
- Cálculo de tempo de permanência
- Cálculo de valor a pagar com base no tempo
- Saída de veículos com liberação de vagas

---

## 📏 Regras do sistema

- Capacidade total: **10 unidades**
- Bloqueia + de 2 Placas iguais
- Carro / Moto → 1 unidade
- Caminhão → 2 unidades
- Pagamento: R$ 5,40 por minuto
- O tempo é calculado entre entrada e saída

---

## 🏗️ Estrutura do projeto

- `Controle`: controla entrada, saída e lógica de vagas
- `Veiculo`: armazena informações de placa, tipo e horário
- `Config`: interface de interação via console
- `App`: ponto de entrada do sistema

---

## 💡 Observação importante

Este projeto foi desenvolvido com foco em **lógica pura e abstração de problemas**, não em simulação física completa ou uso de arquitetura avançada.

O objetivo é demonstrar:
> capacidade de modelar regras, estados e fluxo lógico de um sistema simples.

---

## 📌 Tecnologias

- Java
- API de data/hora (`LocalTime`)
- Estruturas de dados básicas (`ArrayList`, `HashMap`)
