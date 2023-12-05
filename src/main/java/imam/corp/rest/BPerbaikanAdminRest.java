package imam.corp.rest;

import imam.corp.modules.bperbaikanadmin.BPerbaikanAdminService;
import imam.corp.modules.bperbaikanadmin.DTO;
import imam.corp.rest.handler.RestResponse;
import imam.corp.utilities.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/bperbaikanadmin")
public class BPerbaikanAdminRest {

    @Autowired
    BPerbaikanAdminService service;

    @PostMapping(
            path = "/fetch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.list<List<DTO.respBPerbaikanAdmin>> fetching(@RequestBody Map<String, Object> filter) {

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

    @PostMapping(
            path = "detail",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBPerbaikanAdmin> detail(@RequestBody DTO.reqstDetailBPerbaikanAdmin request) {

        DTO.respBPerbaikanAdmin respBPerbaikanAdmin = service.detail(request);

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

    @PostMapping(
            path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBPerbaikanAdmin> create(@RequestBody DTO.reqstUpdateBPerbaikanAdmin request) {

        DTO.respBPerbaikanAdmin respBPerbaikanAdmin = service.update(request);

        return RestResponse.object.<DTO.respBPerbaikanAdmin>builder()
                .data(respBPerbaikanAdmin)
                .status_code(Constants.OK)
                .message(Constants.UPDATE_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "remove",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<String> remove(@RequestBody DTO.reqstDetailBPerbaikanAdmin request) {

        service.remove(request);

        return RestResponse.object.<String>builder()
                .data("")
                .status_code(Constants.OK)
                .message(Constants.DELETE_MESSAGE)
                .build();
    }

}
