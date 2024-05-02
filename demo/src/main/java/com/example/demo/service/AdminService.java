package com.example.demo.service;

import com.example.demo.Model.Admin;
import com.example.demo.dto.AdminDto;

/*
 * Os serviços (Services) são componentes responsáveis por encapsular a lógica de negócios da aplicação.
 * Eles coordenam as operações entre os diferentes componentes da aplicação, como os controladores (Controllers), os modelos (Models) e os repositórios (Repositories).
 */

public interface AdminService {

    Admin save(AdminDto adminDto);
}
