package imam.corp.rest;

import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminService;
import imam.corp.modules.bperbaikanadmin.DTO;
import imam.corp.rest.handler.RestResponse;
import imam.corp.utilities.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/v1/bperbaikanadmin")
public class BPerbaikanAdminRest {

    @Autowired
    BPerbaikanAdminService service;

    @GetMapping(
            path = "/fetch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.list<List<DTO.respBPerbaikanAdmin>> fetching(@RequestParam Map<String, Object> filter) {

        Page<DTO.respBPerbaikanAdmin> respBPerbaikanAdmins = service.fetch(filter);

        return RestResponse.list.<List<DTO.respBPerbaikanAdmin>>builder()
                .list(respBPerbaikanAdmins.getContent())
                .paging(RestResponse.restPagingResponse.builder()
                        .currentPage(respBPerbaikanAdmins.getNumber())
                        .totalPage(respBPerbaikanAdmins.getTotalPages())
                        .sizePage(respBPerbaikanAdmins.getSize())
                        .build())
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @GetMapping(
            path = "detail/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBPerbaikanAdmin> detail(@PathVariable(name = "id") Long id) {

        DTO.respBPerbaikanAdmin respBPerbaikanAdmin = service.detail(id);

        return RestResponse.object.<DTO.respBPerbaikanAdmin>builder()
                .data(respBPerbaikanAdmin)
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBPerbaikanAdmin> create(@RequestBody DTO.reqstBPerbaikanAdmin request) {

        DTO.respBPerbaikanAdmin respBPerbaikanAdmin = service.create(request);

        return RestResponse.object.<DTO.respBPerbaikanAdmin>builder()
                .data(respBPerbaikanAdmin)
                .status_code(Constants.OK)
                .message(Constants.CREATE_MESSAGE)
                .build();

    }

    @PutMapping(
            path = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBPerbaikanAdmin> create(@PathVariable(name = "id") Long id,
                                                               @RequestBody DTO.reqstUpdateBPerbaikanAdmin request) {

        request.setId(id);
        DTO.respBPerbaikanAdmin respBPerbaikanAdmin = service.update(request);

        return RestResponse.object.<DTO.respBPerbaikanAdmin>builder()
                .data(respBPerbaikanAdmin)
                .status_code(Constants.OK)
                .message(Constants.UPDATE_MESSAGE)
                .build();

    }

    @DeleteMapping(
            path = "remove/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<String> remove(@PathVariable(name = "id") Long id) {

        service.remove(id);

        return RestResponse.object.<String>builder()
                .data("")
                .status_code(Constants.OK)
                .message(Constants.DELETE_MESSAGE)
                .build();
    }

}
