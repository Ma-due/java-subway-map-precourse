package subway;

import subway.controller.FrontController;
import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.domain.entity.Line;
import subway.domain.entity.Section;
import subway.domain.entity.Station;
import subway.domain.repository.LineRepository;
import subway.domain.repository.StationRepository;
import subway.service.LineService;
import subway.service.StationService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubwayInitializer {
    private static final List<String> DEFAULT_LINE_INFO =
            Arrays.asList("2호선", "3호선", "신분당역");
    private static final List<String> DEFAULT_STATION_INFO =
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final List<SectionDto> DEFAULT_SECTION_INFO =
            Arrays.asList(
                    new SectionDto("2호선", Arrays.asList("교대역", "강남역", "역삼역")),
                    new SectionDto("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),
                    new SectionDto("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"))
            );

    private SubwayInitializer() {

    }

    public static FrontController init() {
        StationRepository stationRepository = new StationRepository(stationInit());
        LineRepository lineRepository = new LineRepository(lineInit());

        StationService stationService = new StationService(stationRepository);
        LineService lineService = new LineService(lineRepository);

        StationController stationController = new StationController(stationService);
        LineController lineController = new LineController(lineService, stationService);
        SectionController sectionController = new SectionController(lineService, stationService);

        FrontController frontController = new FrontController(stationController, lineController, sectionController);

        return frontController;
    }

    private static List<Station> stationInit() {
        return DEFAULT_STATION_INFO.stream().map(Station::new).collect(Collectors.toList());
    }

    private static List<Line> lineInit() {
        return DEFAULT_SECTION_INFO.stream()
                .map(info -> new Line(info.getLineInfo(), Section.from(info.getSectionInfo())))
                .collect(Collectors.toList());
    }


}
