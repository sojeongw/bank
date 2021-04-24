package com.demo.documentmanagementsystem;

import static com.demo.documentmanagementsystem.Attributes.HEIGHT;
import static com.demo.documentmanagementsystem.Attributes.PATH;
import static com.demo.documentmanagementsystem.Attributes.TYPE;
import static com.demo.documentmanagementsystem.Attributes.WIDTH;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

class ImageImporter implements Importer {

  @Override
  public Document importFile(final File file) throws IOException {
    final Map<String, String> attributes = new HashMap<>();
    attributes.put(PATH, file.getPath());

    final BufferedImage image = ImageIO.read(file);
    attributes.put(WIDTH, String.valueOf(image.getWidth()));
    attributes.put(HEIGHT, String.valueOf(image.getHeight()));
    attributes.put(TYPE, String.valueOf(image.getType()));

    return new Document(attributes);
  }
}
