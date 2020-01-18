package com.test.simulator;

import java.util.List;

public interface ValidationsInterface {
    Boolean ValidateTansitionCodes(List<String> tc);
    Boolean ValidateStateOfMatter(List<String> objects);
}