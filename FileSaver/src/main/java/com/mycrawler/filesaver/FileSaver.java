package com.mycrawler.filesaver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.aeonbits.owner.ConfigFactory;

import com.mycrawler.config.CrawlerConfig;

public class FileSaver {

	private static Supplier<CrawlerConfig> getConfig = () -> ConfigFactory.create(CrawlerConfig.class);

	public static Function<Optional<URL>, Boolean> saveFile = (Optional<URL> imageUrl) -> {
		InputStream inputStream = null;
		File savingFile = null;
		FileOutputStream outputStream = null;
		try {
			if (imageUrl.isPresent()) {

				CrawlerConfig config = getConfig.get();

				// File savingDir = new File(config.downloadDir());
				String path = imageUrl.get().getPath();
				String imageName = path.substring(path.lastIndexOf("/"));

				savingFile = new File(config.downloadDir() + "\\" + imageName);
				if (!savingFile.getParentFile().exists()) {
					savingFile.getParentFile().mkdirs();
				}

				inputStream = imageUrl.get().openStream();
				byte[] buffer = new byte[2048];
				outputStream = new FileOutputStream(savingFile);
				int length = 0;

				while ((length = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, length);
				}
				
				return true;

			}
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
					outputStream = null;
				}

				if (inputStream != null) {
					inputStream.close();
					inputStream = null;
				}

				if (savingFile != null) {
					savingFile = null;
				}
			} catch (Exception excep) {
				excep.printStackTrace();
			}

		}

		return false;

	};

	/*
	 * public Function<Optional<URL>, Boolean> saveFileRetry = (Optional<URL>
	 * imageUrl) -> {
	 * 
	 * if (imageUrl.isPresent()) {
	 * 
	 * }
	 * 
	 * return false;
	 * 
	 * };
	 */

	public static Predicate<URL> canBeSaved = url -> {

		boolean canBeSaved = false;

		try {
			CrawlerConfig config = getConfig.get();

			Path file = Paths.get(url.toURI());

			String extn = Files.probeContentType(file);

			canBeSaved = config.imageExtensionsWhitelist().indexOf(extn) != -1
					&& config.imageExtensionsBlacklist().indexOf(extn) == -1
					&& config.imageDimensionlowerlimitMB() * 1024 < FileChannel.open(file).size();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {

		}

		return canBeSaved;

	};

}
