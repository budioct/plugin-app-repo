package imam.corp.rest;

import imam.corp.modules.barangterimas.BarangTerimaService;
import imam.corp.modules.barangterimas.DTO;
import imam.corp.rest.handler.RestResponse;
import imam.corp.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/barang")
public class BarangTerimaRest {

    @Autowired
    private BarangTerimaService service;

    @PostMapping(
            path = "/fetch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.list<List<DTO.respBarangTerima>> fetchAll(@RequestParam Map<String, Object> filter) {

        Page<DTO.respBarangTerima> respBarangTerimas = service.fetchAll(filter);

        return RestResponse.list.<List<DTO.respBarangTerima>>builder()
                .list(respBarangTerimas.getContent())
                .paging(RestResponse.restPagingResponse.builder()
                        .currentPage(respBarangTerimas.getNumber())
                        .totalPage(respBarangTerimas.getTotalPages())
                        .sizePage(respBarangTerimas.getSize())
                        .build())
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/detail",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangTerima> detail(@RequestBody DTO.reqstDetailBarangTerima request) {

        DTO.respBarangTerima respBarangTerima = service.detail(request);

        return RestResponse.object.<DTO.respBarangTerima>builder()
                .data(respBarangTerima)
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangTerima> create(@RequestBody DTO.reqstBarangTerima request) {

        DTO.respBarangTerima respBarangTerima = service.create(request);

        return RestResponse.object.<DTO.respBarangTerima>builder()
                .data(respBarangTerima)
                .status_code(Constants.OK)
                .message(Constants.CREATE_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangTerima> update(@RequestBody DTO.reqstUpdtBarangTerima request) {

        DTO.respBarangTerima respBarangTerima = service.update(request);

        return RestResponse.object.<DTO.respBarangTerima>builder()
                .data(respBarangTerima)
                .status_code(Constants.OK)
                .message(Constants.UPDATE_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/remove",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<String> delete(@RequestBody DTO.reqstDetailBarangTerima request) {

        service.delete(request);

        return RestResponse.object.<String>builder()
                .data("")
                .status_code(Constants.OK)
                .message(Constants.DELETE_MESSAGE)
                .build();

    }


}
