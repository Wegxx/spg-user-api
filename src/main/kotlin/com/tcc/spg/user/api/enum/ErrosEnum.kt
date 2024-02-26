package com.tcc.spg.user.api.enum

enum class ErrosEnum(var message: String) {
    WRONG_PASSWORD(message = "A senha informada não corresponde às crednciais de login:"),
    DUPLICATED_LOGIN(message = "O email fornecido já esta sendo utilizado, por favor utilize outro endereço"),
    USER_NOT_FOUND(message = "Usuário com o seguinte login não encontrado: "),
    ERROR_WHILE_GENERATING_TOKEN(message = "Erro inesperado ao tentar gerar o token para o usuário:  ")
}