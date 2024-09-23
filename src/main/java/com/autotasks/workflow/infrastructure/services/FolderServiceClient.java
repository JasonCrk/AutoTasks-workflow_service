package com.autotasks.workflow.infrastructure.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "folder-service")
public interface FolderServiceClient {

    @GetMapping("/api/v1/folders/{id}/exists")
    void existsById(@PathVariable("id") UUID id);
}
