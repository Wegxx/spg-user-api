package com.tcc.spg.user.api.enum

enum class ErrosEnum(var message: String) {
    WRONG_PASSWORD(message = "A senha informada não corresponde às crednciais de login:"),
    DUPLICATED_LOGIN(message = "O email fornecido já esta sendo utilizado, por favor utilize outro endereço"),
    REGISTER_NOT_FOUND(message = "Registro com a seguinte credencial não encontrado: "),
    ERROR_WHILE_GENERATING_TOKEN(message = "Erro inesperado ao tentar gerar o token para o usuário:  "),
    BAD_CREDENTIALS(message = "Usuário inexistente ou senha inválida"),
    DUPLICATED_SPECIALIZATION(message = "O nome da especialização fornecida já esta sendo utilizado, por favor escolha outro"),
    DUPLICATED_MATRIX(message = "O nome da matrix fornecida já esta sendo utilizado, por favor escolha outra"),
    BAD_REQUEST(message = "Esse erro ocorre devido a parametros errados ou invalidos no request. Por favor confira sua requisição e tente novamente."),

}