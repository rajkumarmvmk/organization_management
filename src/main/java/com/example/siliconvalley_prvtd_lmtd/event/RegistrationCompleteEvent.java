package com.example.siliconvalley_prvtd_lmtd.event;

import com.example.siliconvalley_prvtd_lmtd.entity.AdminEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private AdminEntity adminEntity;
    private String applicationUrl;
    public RegistrationCompleteEvent(AdminEntity adminEntity,String applicationUrl) {
        super(adminEntity);
        this.adminEntity=adminEntity;
        this.applicationUrl=applicationUrl;
    }
}
