package imam.corp.rest;

import imam.corp.modules.barangperbaikan.BarangPerbaikanService;
import imam.corp.modules.barangperbaikan.DTO;
import imam.corp.rest.handler.RestResponse;
import imam.corp.utilities.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/bperbaikan")
public class BarangPerbaikanRest {

    @Autowired
    BarangPerbaikanService service;

    @PostMapping(
            path = "/fetch",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.list<List<DTO.respBarangPerbaikan>> fetching(@RequestBody Map<String, Object> filter) {

        Page<DTO.respBarangPerbaikan> respBarangPerbaikans = service.fetch(filter);

        return RestResponse.list.<List<DTO.respBarangPerbaikan>>builder()
                .list(respBarangPerbaikans.getContent())
                .paging(RestResponse.restPagingResponse.builder()
                        .currentPage(respBarangPerbaikans.getNumber())
                        .totalPage(respBarangPerbaikans.getTotalPages())
                        .sizePage(respBarangPerbaikans.getSize())
                        .build())
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "detail",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangPerbaikan> detail(@RequestBody DTO.reqstDetailBarangPerbaikan request) {

        DTO.respBarangPerbaikan respBarangPerbaikan = service.detail(request);

        return RestResponse.object.<DTO.respBarangPerbaikan>builder()
                .data(respBarangPerbaikan)
                .status_code(Constants.OK)
                .message(Constants.ITEM_EXIST_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangPerbaikan> create(@RequestBody DTO.reqstBarangPerbaikan request) {

        DTO.respBarangPerbaikan respBarangPerbaikan = service.create(request);

        return RestResponse.object.<DTO.respBarangPerbaikan>builder()
                .data(respBarangPerbaikan)
                .status_code(Constants.OK)
                .message(Constants.CREATE_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<DTO.respBarangPerbaikan> update(@RequestBody DTO.reqstUpdtBarangPerbaikan request) {

        DTO.respBarangPerbaikan respBarangPerbaikan = service.update(request);

        return RestResponse.object.<DTO.respBarangPerbaikan>builder()
                .data(respBarangPerbaikan)
                .status_code(Constants.OK)
                .message(Constants.UPDATE_MESSAGE)
                .build();

    }

    @PostMapping(
            path = "/remove",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public RestResponse.object<String> remove(@RequestBody DTO.reqstDetailBarangPerbaikan request) {

        service.remove(request);

        return RestResponse.object.<String>builder()
                .data("")
                .status_code(Constants.OK)
                .message(Constants.DELETE_MESSAGE)
                .build();

    }


}
