package org.acme.dto;

import org.acme.entities.TpUsers;
import org.acme.entities.User;

public class UserDto {
    private Long cdUser;
    private String nmUser;
    private TpUsers tpUser;
    private String cpf;

    public Long getCdUser() {
        return cdUser;
    }

    public void setCdUser(Long cdUser) {
        this.cdUser = cdUser;
    }

    public String getNmUser() {
        return nmUser;
    }

    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }

    public TpUsers getTpUser() {
        return tpUser;
    }

    public void setTpUser(TpUsers tpUser) {
        this.tpUser = tpUser;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UserDto() {}

    public UserDto(User user) {
        this.cdUser = user.cdUser;
        this.nmUser = user.nmUser;
        this.tpUser = user.tpUser;
        this.cpf = user.cpf;
    }
}
