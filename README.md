# Interactive Image Board

Aplicação Android desenvolvida em **Kotlin** utilizando **Jetpack Compose**, que funciona como um quadro interativo de imagens.

O usuário pode selecionar múltiplas imagens da galeria, posicioná-las livremente dentro de uma área de edição, reproduzir um efeito sonoro ao tocar nas imagens e confirmar individualmente a posição de cada uma.

## Funcionalidades

* Seleção de uma ou várias imagens da galeria.
* Exibição das imagens em uma área de edição delimitada.
* Movimentação individual de cada imagem através de gestos de arrastar.
* Controle independente do estado de cada imagem.
* Reprodução do arquivo `ping.mp3` ao tocar em qualquer imagem.
* Confirmação individual de imagens.
* Bloqueio da movimentação após confirmação.
* Mensagem de feedback informando qual imagem foi confirmada.

## Tecnologias utilizadas

* **Kotlin**
* **Android Studio**
* **Jetpack Compose**
* **Material 3**
* **ViewModel**
* **Coil** para carregamento de imagens
* **MediaPlayer** para reprodução de áudio

## Requisitos

* Android Studio atualizado.
* Android SDK 36.
* Kotlin compatível com o projeto.
* Dispositivo físico ou emulador Android com API 24 ou superior.

## Como executar

### 1. Clonar o repositório

```bash
git clone https://github.com/GabrielSantos967/DragAndDropImages.git
```

### 2. Abrir o projeto

Abra a pasta clonada no Android Studio.

O Gradle irá baixar automaticamente as dependências necessárias.

### 3. Executar

Execute o aplicativo em um emulador ou dispositivo Android conectado.

## Organização do projeto

O projeto utiliza uma separação entre interface, lógica e modelos de dados.

```
app/
   src/main/java/com/example/interactiveimageboard/

       model/
           ImageItem.kt
     
       uiPackage/
           MainScreen.kt
           ImageCard.kt
     
        viewmodel/
           MainViewModel.kt
```

## Arquitetura

### Interface (`uiPackage`)

Responsável por:

* Exibir os componentes visuais.
* Receber eventos de toque e gestos.
* Atualizar a interface conforme os estados das imagens.
* Exibir mensagens de feedback.

### ViewModel

Responsável por:

* Gerenciar a lista de imagens adicionadas.
* Controlar a seleção de imagens.
* Confirmar imagens individualmente.
* Atualizar mensagens exibidas ao usuário.

### Modelo (`ImageItem`)

Cada imagem possui seu próprio estado:

* Identificador único.
* Posição X e Y.
* Escala.
* Estado de seleção.
* Estado de confirmação.

Exemplo:

```kotlin
ImageItem(
    id = 1,
    uri = imageUri
)
```

## Implementação dos gestos

As imagens utilizam o sistema de gestos do Jetpack Compose através de:

```kotlin
detectTransformGestures
```

Isso permite:

* Arrastar imagens individualmente.
* Aplicar movimentação somente na imagem selecionada.
* Bloquear alterações após a confirmação.

As posições são controladas através das propriedades:

```kotlin
x
y
```

e limitadas para manter as imagens dentro da área de edição.

## Reprodução de áudio

O aplicativo utiliza o recurso nativo:

```kotlin
MediaPlayer
```

O arquivo:

```
ping.mp3
```

fica armazenado nos recursos locais:

```
app/src/main/res/raw/ping.mp3
```

Ao tocar em uma imagem, o áudio é reproduzido imediatamente.

Imagens confirmadas continuam reproduzindo o som normalmente.

## Decisões técnicas

### Jetpack Compose

Foi escolhido por permitir uma construção declarativa da interface, facilitando o controle dos estados das imagens e atualização automática dos componentes.

### ViewModel

O estado das imagens foi mantido fora da interface para evitar que a lógica de negócio fique diretamente acoplada aos componentes visuais.

### Coil

A biblioteca Coil foi utilizada para carregar imagens através de objetos `Uri`, oferecendo integração simples com o Jetpack Compose.

### Estados individuais

Cada imagem possui seu próprio estado (`isSelected` e `isLocked`), permitindo que uma imagem seja confirmada sem afetar as demais.

## Limitações conhecidas

* As posições das imagens não são salvas após fechar o aplicativo.
* Não existe remoção de imagens adicionadas.
* Não há suporte para rotação manual.
* O redimensionamento ocorre apenas através do gesto de escala, com os dedos em formato de pinça. Precisa estar dentro da borda.
* As imagens adicionadas ficam apenas durante a execução atual do aplicativo.

## Recursos incluídos

* Código-fonte completo.
* Arquivo `ping.mp3`.
* Configurações necessárias para execução.

## Licença

Projeto desenvolvido para fins de avaliação técnica.
