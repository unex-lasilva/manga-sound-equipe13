from pathlib import Path

# Conteúdo do README.md
readme_content = """
# 🎵 Manga Sound Template

Bem-vindo ao **Manga Sound Template**, um projeto de reprodutor de música orientado a objetos!  
A proposta é proporcionar uma experiência imersiva por meio de listas de reprodução personalizadas. A música é uma linguagem universal e, neste projeto, valorizamos sua capacidade de despertar memórias, emoções e conexões.

## 📜 Descrição

Um par de fones de ouvido, sua lista de reprodução favorita e pronto: você está totalmente imerso(a) em uma atmosfera só sua.  
A música tem muitos significados e eles mudam conforme você muda. Em cada momento da sua vida, uma mesma música pode significar diferentes coisas. Pode guardar uma memória, produzir uma emoção, unir ou separar.

Sem dúvidas, a música é a arte de manifestar os mais variados sentimentos da alma. Não é à toa que foi uma das primeiras artes desenvolvidas pela humanidade.

O **Manga Sound** é um aplicativo de reprodução de música que organiza os arquivos de áudio do usuário em um repositório central, possibilitando a criação de listas de reprodução e outras operações.

## 🧩 Diagrama de Classes

O sistema foi modelado com base em programação orientada a objetos. Abaixo, temos o diagrama de classes:

![Diagrama de Classes](./image.png)

### Principais Classes

- **MangaController**: Classe principal que gerencia músicas, listas de reprodução e execução.
- **Musica**: Representa uma música com título, artista, duração e caminho do arquivo.
- **ListaReproducao**: Estrutura de dados que agrupa músicas.
- **ReprodutorLista**: Responsável por executar as músicas da lista.
- **ListaEncadeada & No**: Implementações próprias de estrutura de dados para armazenar objetos de forma encadeada.

## ⚙️ Funcionalidades

- Adicionar/Remover músicas no repositório.
- Criar/Excluir listas de reprodução.
- Inserir e remover músicas em posições específicas da lista.
- Iniciar, pausar e passar músicas.
- Voltar à música anterior e reiniciar uma lista.

## 👥 Equipe

1.  
2.  

*Adicione aqui os nomes dos integrantes do grupo.*
"""

# Caminho para salvar o arquivo
output_path = Path("/mnt/data/README.md")
output_path.write_text(readme_content.strip(), encoding="utf-8")

# Retornar o caminho do arquivo
output_path.name
