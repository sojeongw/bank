package com.demo.documentmanagementsystem;

import static com.demo.documentmanagementsystem.Attributes.PATH;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextFile {

  void addLineSuffix(final String prefix, final String attributeName) {
    for(final String line: lines) {
      if(line.startsWith(prefix)) {
        attributes.put(attributeName, line.substring(prefix.length()));
        break;
      }
    }
  }
}
